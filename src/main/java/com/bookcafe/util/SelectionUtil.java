package com.bookcafe.util;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.bookcafe.data.BookData;
import com.bookcafe.data.CartData;
import com.bookcafe.data.BeveragesData;
import com.bookcafe.data.CookingClassData;
import com.bookcafe.data.FoodsData;
import com.bookcafe.data.ReadingClubData;
import com.bookcafe.dto.BookCart;
import com.bookcafe.dto.CartList;
import com.bookcafe.dto.ClassCart;
import com.bookcafe.dto.ClubCart;
import com.bookcafe.dto.ItemCart;
import com.bookcafe.dto.ProductCart;
import com.bookcafe.dto.Selection;
import com.bookcafe.model.Books;
import com.bookcafe.model.Beverages;
import com.bookcafe.model.CookingClass;
import com.bookcafe.model.Foods;
import com.bookcafe.model.ReadingClub;
import com.bookcafe.model.SavedCart;
import com.bookcafe.repository.BooksRepository;
import com.bookcafe.repository.CartRepository;
import com.bookcafe.repository.BeveragesRepository;
import com.bookcafe.repository.CookingClassRepository;
import com.bookcafe.repository.FoodsRepository;
import com.bookcafe.repository.ReadingclubRepository;

@Component
public class SelectionUtil {
	
	@Autowired
	private BookData bookData;
	
	@Autowired
	private FoodsData productData;
	
	@Autowired
	private BeveragesData itemData;
	
	@Autowired
	private ReadingClubData clubData;
	
	@Autowired
	private CookingClassData classData;
	
	@Autowired
	private CartData cartData;
	
	@Autowired
	public CartRepository cartRepository;
	
	@Autowired
	public BooksRepository bookRepository;
	
	@Autowired
	public FoodsRepository productsRepository;
	
	@Autowired
	public BeveragesRepository itemsRepository;
	
	@Autowired
	public CookingClassRepository masterclassRepository;
	
	@Autowired
	public ReadingclubRepository readingclubRepository;
	
	@Value( "${current.env}" )
	private String env;
	
	public String submitOrder(Selection selection) {
		if(selection != null && selection.getPaymentMode() > 0) {
			return "Order created with Order Id : "+selection.getCartId();
		}
		return "Something went wrong. Please try again";
	}
	
	public Selection removeEntry(int cartId, int id) {
		Selection selection = this.retrieveCart(cartId);
		if(selection != null && selection.getCartList()!= null && !selection.getCartList().isEmpty()) {
			Iterator<CartList> cartListIterator = selection.getCartList().iterator();
			while(cartListIterator.hasNext()) {
				CartList next = cartListIterator.next();
				if(next != null && next.getId() == id) {
					cartListIterator.remove();
					selection.setTotalAmt(selection.getTotalAmt()-next.getAmt());
					break;
				}
			}
		}
		return selection;
	}
	
	public Selection retrieveCart(int cartId) {
		if(env.equalsIgnoreCase("Mock")) {
			return retrieveCartMock(cartId);
		} else {
			return retrieveCartReal(cartId);
		}
	}
	
	private Selection retrieveCartReal(int cartId) {
		Selection selection = new Selection();
		selection.setCartId(cartId);
		SavedCart savedCart = cartRepository.findById(cartId).get();
		
		List<CartList> cartList = new ArrayList<>();
		selection.setCartList(cartList );
		double totalAmount = 0;
		
		if(savedCart.getBooks() != null && !savedCart.getBooks().isEmpty()) {
			for(BookCart bookCart : savedCart.getBooks()) {
				CartList cartItem = new CartList();
				cartItem.setId(bookCart.getBookId());
				cartItem.setQuantity(bookCart.getBookQuantity());
				for(Books book : bookRepository.findAll()) {
					if(book.getBookId()==bookCart.getBookId()) {
						cartItem.setName(book.getName());
						cartItem.setAmt(book.getPrice()*bookCart.getBookQuantity());
						totalAmount = totalAmount + cartItem.getAmt();
					}
				}
				cartList.add(cartItem);
			}
		}
		if(savedCart.getProducts() != null && !savedCart.getProducts().isEmpty()) {
			for(ProductCart productCart : savedCart.getProducts()) {
				CartList cartItem = new CartList();
				cartItem.setId(productCart.getProductId());
				cartItem.setQuantity(productCart.getProductQuantity());
				for(Foods product : productsRepository.findAll()) {
					if(product.getFoodId()==productCart.getProductId()) {
						cartItem.setName(product.getName());
						cartItem.setAmt(product.getPrice()*productCart.getProductQuantity());
						totalAmount = totalAmount + cartItem.getAmt();
					}
				}
				cartList.add(cartItem);
			}
		}
		if(savedCart.getItems() != null && !savedCart.getItems().isEmpty()) {
			for(ItemCart itemCart : savedCart.getItems()) {
				CartList cartItem = new CartList();
				cartItem.setId(itemCart.getItemId());
				cartItem.setQuantity(itemCart.getItemQuantity());
				for(Beverages item : itemsRepository.findAll()) {
					if(item.getBeveragesId()==itemCart.getItemId()) {
						cartItem.setName(item.getName());
						cartItem.setAmt(Integer.parseInt(item.getPrice())*itemCart.getItemQuantity());
						totalAmount = totalAmount + cartItem.getAmt();
					}
				}
				cartList.add(cartItem);
			}
		}
		if(savedCart.getClubs() != null && !savedCart.getClubs().isEmpty()) {
			for(ClubCart clubCart : savedCart.getClubs()) {
				CartList cartItem = new CartList();
				cartItem.setId(clubCart.getClubId());
				cartItem.setQuantity(clubCart.getClubQuantity());
				for(ReadingClub club : readingclubRepository.findAll()) {
					if(club.getClubId()==clubCart.getClubId()) {
						cartItem.setName(club.getBookName()+" For "+club.getSuitableFor());
						cartItem.setAmt(Integer.parseInt(club.getPrice())*clubCart.getClubQuantity());
						totalAmount = totalAmount + cartItem.getAmt();
					}
				}
				cartList.add(cartItem);
			}
		}
		if(savedCart.getClasses() != null && !savedCart.getClasses().isEmpty()) {
			for(ClassCart classCart : savedCart.getClasses()) {
				CartList cartItem = new CartList();
				cartItem.setId(classCart.getClassId());
				cartItem.setQuantity(classCart.getClassQuantity());
				for(CookingClass mclass : masterclassRepository.findAll()) {
					if(mclass.getClassId()==classCart.getClassId()) {
						cartItem.setName(mclass.getRecipeName()+" For "+mclass.getSuitableFor());
						cartItem.setAmt(Integer.parseInt(mclass.getPrice())*classCart.getClassQuantity());
						totalAmount = totalAmount + cartItem.getAmt();
					}
				}
				cartList.add(cartItem);
			}
		}
		selection.setPaymentMode(0);
		selection.setTotalAmt(totalAmount);
		return selection;
	}
	
	private Selection retrieveCartMock(int cartId) {
		Selection selection = new Selection();
		selection.setCartId(cartId);
		SavedCart savedCart = cartData.getData(cartId);
		
		List<CartList> cartList = new ArrayList<>();
		selection.setCartList(cartList );
		double totalAmount = 0;
		
		if(savedCart.getBooks() != null && !savedCart.getBooks().isEmpty()) {
			for(BookCart bookCart : savedCart.getBooks()) {
				CartList cartItem = new CartList();
				cartItem.setId(bookCart.getBookId());
				cartItem.setQuantity(bookCart.getBookQuantity());
				for(Books book : bookData.getData()) {
					if(book.getBookId()==bookCart.getBookId()) {
						cartItem.setName(book.getName());
						cartItem.setAmt(book.getPrice()*bookCart.getBookQuantity());
						totalAmount = totalAmount + cartItem.getAmt();
					}
				}
				cartList.add(cartItem);
			}
		}
		if(savedCart.getProducts() != null && !savedCart.getProducts().isEmpty()) {
			for(ProductCart productCart : savedCart.getProducts()) {
				CartList cartItem = new CartList();
				cartItem.setId(productCart.getProductId());
				cartItem.setQuantity(productCart.getProductQuantity());
				for(Foods product : productData.getData()) {
					if(product.getFoodId()==productCart.getProductId()) {
						cartItem.setName(product.getName());
						cartItem.setAmt(product.getPrice()*productCart.getProductQuantity());
						totalAmount = totalAmount + cartItem.getAmt();
					}
				}
				cartList.add(cartItem);
			}
		}
		if(savedCart.getItems() != null && !savedCart.getItems().isEmpty()) {
			for(ItemCart itemCart : savedCart.getItems()) {
				CartList cartItem = new CartList();
				cartItem.setId(itemCart.getItemId());
				cartItem.setQuantity(itemCart.getItemQuantity());
				for(Beverages item : itemData.getData()) {
					if(item.getBeveragesId()==itemCart.getItemId()) {
						cartItem.setName(item.getName());
						cartItem.setAmt(Integer.parseInt(item.getPrice())*itemCart.getItemQuantity());
						totalAmount = totalAmount + cartItem.getAmt();
					}
				}
				cartList.add(cartItem);
			}
		}
		if(savedCart.getClubs() != null && !savedCart.getClubs().isEmpty()) {
			for(ClubCart clubCart : savedCart.getClubs()) {
				CartList cartItem = new CartList();
				cartItem.setId(clubCart.getClubId());
				cartItem.setQuantity(clubCart.getClubQuantity());
				for(ReadingClub club : clubData.getData()) {
					if(club.getClubId()==clubCart.getClubId()) {
						cartItem.setName(club.getBookName()+" For "+club.getSuitableFor());
						cartItem.setAmt(Integer.parseInt(club.getPrice())*clubCart.getClubQuantity());
						totalAmount = totalAmount + cartItem.getAmt();
					}
				}
				cartList.add(cartItem);
			}
		}
		if(savedCart.getClasses() != null && !savedCart.getClasses().isEmpty()) {
			for(ClassCart classCart : savedCart.getClasses()) {
				CartList cartItem = new CartList();
				cartItem.setId(classCart.getClassId());
				cartItem.setQuantity(classCart.getClassQuantity());
				for(CookingClass mclass : classData.getData()) {
					if(mclass.getClassId()==classCart.getClassId()) {
						cartItem.setName(mclass.getRecipeName()+" For "+mclass.getSuitableFor());
						cartItem.setAmt(Integer.parseInt(mclass.getPrice())*classCart.getClassQuantity());
						totalAmount = totalAmount + cartItem.getAmt();
					}
				}
				cartList.add(cartItem);
			}
		}
		selection.setPaymentMode(0);
		selection.setTotalAmt(totalAmount);
		return selection;
	}

}
