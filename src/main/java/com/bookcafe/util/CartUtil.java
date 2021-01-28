package com.bookcafe.util;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.bookcafe.dto.BookCart;
import com.bookcafe.dto.Cart;
import com.bookcafe.dto.ClassCart;
import com.bookcafe.dto.ClubCart;
import com.bookcafe.dto.ItemCart;
import com.bookcafe.dto.ProductCart;
import com.bookcafe.model.SavedCart;
import com.bookcafe.repository.CartRepository;

@Component
public class CartUtil {
	
	@Autowired
	public CartRepository cartRepository;
	
	public String saveCart(Cart cart) {
		
		if(cart!=null && cart.getCartId() != 0) {
			Optional<SavedCart> dbCart = cartRepository.findById(cart.getCartId());
			if(dbCart != null) {
				SavedCart savedCart = dbCart.get();
				if(cart.getBookId() != 0) {
					if(savedCart.getBooks() != null && !savedCart.getBooks().isEmpty() && savedCart.getBooks().size() > 0) {
						boolean bookExists = false;
						Iterator<BookCart> bookIterator = savedCart.getBooks().iterator();
						while(bookIterator.hasNext()) {
							BookCart books = bookIterator.next();
							if(books.getBookId() == cart.getBookId()) {
								books.setBookQuantity(cart.getBookQuantity());
								bookExists = true;
								break;
							}
						}
						if(!bookExists) {
							BookCart books = new BookCart();
							books.setBookId(cart.getBookId());
							books.setBookQuantity(cart.getBookQuantity());
							savedCart.getBooks().add(books );
						}
					} else {
						List<BookCart> book = new ArrayList<>();
						BookCart bookCart = new BookCart();
						bookCart.setBookId(cart.getBookId());
						bookCart.setBookQuantity(cart.getBookQuantity());
						book.add(bookCart );
						savedCart.setBooks(book );
					}
				}
				if(cart.getProductId() != 0) {
					if(savedCart.getProducts() != null && !savedCart.getProducts().isEmpty() && savedCart.getProducts().size() > 0) {
						boolean productExists = false;
						Iterator<ProductCart> productIterator = savedCart.getProducts().iterator();
						while(productIterator.hasNext()) {
							ProductCart products = productIterator.next();
							if(products.getProductId() == cart.getProductId()) {
								products.setProductQuantity(cart.getProductQuantity());
								productExists = true;
								break;
							}
						}
						if(!productExists) {
							ProductCart books = new ProductCart();
							books.setProductId(cart.getProductId());
							books.setProductQuantity(cart.getProductQuantity());
							savedCart.getProducts().add(books );
						}
					} else {
						List<ProductCart> product = new ArrayList<>();
						ProductCart productCart = new ProductCart();
						productCart.setProductId(cart.getProductId());
						productCart.setProductQuantity(cart.getProductQuantity());
						product.add(productCart );
						savedCart.setProducts(product );
					}
				}
				if(cart.getItemId() != 0) {
					if(savedCart.getItems() != null && !savedCart.getItems().isEmpty() && savedCart.getItems().size() > 0) {
						boolean itemExists = false;
						Iterator<ItemCart> itemIterator = savedCart.getItems().iterator();
						while(itemIterator.hasNext()) {
							ItemCart items = itemIterator.next();
							if(items.getItemId() == cart.getItemId()) {
								items.setItemQuantity(cart.getItemQuantity());
								itemExists = true;
								break;
							}
						}
						if(!itemExists) {
							ItemCart items = new ItemCart();
							items.setItemId(cart.getItemId());
							items.setItemQuantity(cart.getItemQuantity());
							savedCart.getItems().add(items );
						}
					} else {
						List<ItemCart> item = new ArrayList<>();
						ItemCart itemCart = new ItemCart();
						itemCart.setItemId(cart.getItemId());
						itemCart.setItemQuantity(cart.getItemQuantity());
						item.add(itemCart );
						savedCart.setItems(item );
					}
				}
				if(cart.getClassId() != 0) {
					if(savedCart.getClasses() != null && !savedCart.getClasses().isEmpty() && savedCart.getClasses().size() > 0) {
						boolean classExists = false;
						Iterator<ClassCart> classIterator = savedCart.getClasses().iterator();
						while(classIterator.hasNext()) {
							ClassCart classes = classIterator.next();
							if(classes.getClassId() == cart.getClassId()) {
								classes.setClassQuantity(cart.getClassQuantity());
								classExists = true;
								break;
							}
						}
						if(!classExists) {
							ClassCart classes = new ClassCart();
							classes.setClassId(cart.getClassId());
							classes.setClassQuantity(cart.getClassQuantity());
							savedCart.getClasses().add(classes );
						}
					} else {
						List<ClassCart> masterclass = new ArrayList<>();
						ClassCart masterclassCart = new ClassCart();
						masterclassCart.setClassId(cart.getClassId());
						masterclassCart.setClassQuantity(cart.getClassQuantity());
						masterclass.add(masterclassCart );
						savedCart.setClasses(masterclass );
					}
				}
				if(cart.getClubId() != 0) {
					if(savedCart.getClubs() != null && !savedCart.getClubs().isEmpty() && savedCart.getClubs().size() > 0) {
						boolean clubExists = false;
						Iterator<ClubCart> clubIterator = savedCart.getClubs().iterator();
						while(clubIterator.hasNext()) {
							ClubCart clubs = clubIterator.next();
							if(clubs.getClubId() == cart.getClubId()) {
								clubs.setClubQuantity(cart.getClubQuantity());
								clubExists = true;
								break;
							}
						}
						if(!clubExists) {
							ClubCart clubs = new ClubCart();
							clubs.setClubId(cart.getClubId());
							clubs.setClubQuantity(cart.getClubQuantity());
							savedCart.getClubs().add(clubs );
						}
					} else {
						List<ClubCart> readingclub = new ArrayList<>();
						ClubCart readingclubCart = new ClubCart();
						readingclubCart.setClubId(cart.getClubId());
						readingclubCart.setClubQuantity(cart.getClubQuantity());
						readingclub.add(readingclubCart );
						savedCart.setClubs(readingclub );
					}
				}
				cartRepository.save(savedCart);
				return "Updated to cart successfully";
			} else {
				SavedCart newCart = new SavedCart();
				if(cart.getBookId() != 0) {
					List<BookCart> book = new ArrayList<>();
					BookCart bookCart = new BookCart();
					bookCart.setBookId(cart.getBookId());
					bookCart.setBookQuantity(cart.getBookQuantity());
					book.add(bookCart );
					newCart.setBooks(book );
				}
				if(cart.getProductId() != 0) {
					List<ProductCart> product = new ArrayList<>();
					ProductCart productCart = new ProductCart();
					productCart.setProductId(cart.getProductId());
					productCart.setProductQuantity(cart.getProductQuantity());
					product.add(productCart );
					newCart.setProducts(product );
				}
				if(cart.getItemId() != 0) {
					List<ItemCart> item = new ArrayList<>();
					ItemCart itemCart = new ItemCart();
					itemCart.setItemId(cart.getItemId());
					itemCart.setItemQuantity(cart.getItemQuantity());
					item.add(itemCart );
					newCart.setItems(item );
				}
				if(cart.getClassId() != 0) {
					List<ClassCart> masterclass = new ArrayList<>();
					ClassCart masterclassCart = new ClassCart();
					masterclassCart.setClassId(cart.getClassId());
					masterclassCart.setClassQuantity(cart.getClassQuantity());
					masterclass.add(masterclassCart );
					newCart.setClasses(masterclass );
				}
				if(cart.getClubId() != 0) {
					List<ClubCart> readingclub = new ArrayList<>();
					ClubCart readingclubCart = new ClubCart();
					readingclubCart.setClubId(cart.getClubId());
					readingclubCart.setClubQuantity(cart.getClubQuantity());
					readingclub.add(readingclubCart );
					newCart.setClubs(readingclub );
				}
				newCart.setCartId(cart.getCartId());
				cartRepository.save(newCart);
				return "Added to cart successfully";
			}
		}
		return "Please try again";
	}

}
