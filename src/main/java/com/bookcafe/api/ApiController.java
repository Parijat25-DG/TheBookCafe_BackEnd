package com.bookcafe.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.bookcafe.dto.Cart;
import com.bookcafe.dto.Customer;
import com.bookcafe.dto.Selection;
import com.bookcafe.model.Books;
import com.bookcafe.model.Items;
import com.bookcafe.model.MasterClass;
import com.bookcafe.model.Products;
import com.bookcafe.model.Query;
import com.bookcafe.model.ReadingClub;
import com.bookcafe.model.User;
import com.bookcafe.util.BookUtil;
import com.bookcafe.util.CartUtil;
import com.bookcafe.util.ItemUtil;
import com.bookcafe.util.MasterClassUtil;
import com.bookcafe.util.ProductUtil;
import com.bookcafe.util.QueryUtil;
import com.bookcafe.util.ReadingClubUtil;
import com.bookcafe.util.SelectionUtil;
import com.bookcafe.util.UserUtil;

@CrossOrigin("*")
@RestController
public class ApiController {
	
	@Autowired
	private UserUtil userUtil;
	
	@Autowired
	private BookUtil bookUtil;
	
	@Autowired
	private ItemUtil itemUtil;
	
	@Autowired
	private ProductUtil productUtil;
	
	@Autowired
	private QueryUtil queryUtil;
	
	@Autowired
	private ReadingClubUtil readingClubUtil;
	
	@Autowired
	private MasterClassUtil masterClassUtil;
	
	@Autowired
	private CartUtil cartUtil;
	
	@Autowired
	private SelectionUtil selectionUtil;
	
	@GetMapping("/removeEntry/{cartId}/{id}")
	public Selection retrieveCart(@PathVariable String cartId,@PathVariable String id){
		return selectionUtil.removeEntry(Integer.parseInt(cartId),Integer.parseInt(id));
	}
	
	@PostMapping("/submitOrder")
	public String submitOrder(@RequestBody Selection selection) {
		return selectionUtil.submitOrder(selection);
	}
	
	@GetMapping("/retrieveCart/{cartId}")
	public Selection retrieveCart(@PathVariable String cartId){
		return selectionUtil.retrieveCart(Integer.parseInt(cartId));
	}
	
	@PostMapping("/saveCart")
	public String saveCart(@RequestBody Cart cart) {
		return cartUtil.saveCart(cart);
	}
	
	@PostMapping("/saveQuery")
	public String saveQuery(@RequestBody Query query) {
		return queryUtil.saveQuery(query);
	}
	
	@PostMapping("/loginUser")
	public String loginUser(@RequestBody Customer customer) {
		return userUtil.loginUser(customer);
	}
	
	@PostMapping("/registerUser")
	public String registerUser(@RequestBody User user) {
		double newUser = userUtil.addNewUser(user);
		if(newUser == 0) {
			return "Please enter valid details";
		} else {
			return "You have registered successfully with user ID : "+newUser;
		}
	}
	
	@GetMapping("/getAllUsers")
	public List<User> findAllUsers(){
		return userUtil.retriveAllUsers();
	}
	
	@GetMapping("/getAllProducts")
	public List<Products> findAllProducts(){
		return productUtil.retriveAllProducts();
	}
	
	@PostMapping("/addProduct")
	public String addProduct(@RequestBody Products product) {
		return "New Product added with ID : "+productUtil.addNewProduct(product);
	}
	
	@PostMapping("/removeProduct")
	public String removeProduct(@RequestBody Products product) {
		productUtil.removeProduct(product);
		return "Product with ID : "+product.getProductId()+" deleted successfully";
	}
	
	@GetMapping("/getAllItems")
	public List<Items> findAllItems(){
		return itemUtil.retriveAllItems();
	}
	
	@PostMapping("/addItem")
	public String addItem(@RequestBody Items item) {
		return "New Item added with ID : "+itemUtil.addNewItem(item);
	}
	
	@PostMapping("/removeItem")
	public String removeItem(@RequestBody Items item) {
		itemUtil.removeItem(item);
		return "Item with ID : "+item.getItemId()+" deleted successfully";
	}
	
	@GetMapping("/getAllBooks")
	public List<Books> findAllBooks(){
		return bookUtil.retriveAllBooks();
	}
	
	@PostMapping("/addBook")
	public String addBook(@RequestBody Books book) {
		return "New Book added with ID : "+bookUtil.addNewBook(book);
	}
	
	@PostMapping("/removeBook")
	public String removeBook(@RequestBody Books book) {
		bookUtil.removeBook(book);
		return "Book with ID : "+book.getBookId()+" deleted successfully";
	}
	
	@GetMapping("/getReadingClubs")
	public List<ReadingClub> findAllReadingClubs(){
		return readingClubUtil.retrieveReadingClubDetails();
	}
	
	@PostMapping("/addReadingClub")
	public String addReadingClub(@RequestBody ReadingClub clubs) {
		return "New Club added with ID : "+readingClubUtil.addNewReadingClub(clubs);
	}
	
	@PostMapping("/removeReadingClub")
	public String removeReadingClub(@RequestBody ReadingClub clubs) {
		readingClubUtil.removeReadingClub(clubs);
		return "Reading Club with ID : "+clubs.getClubId()+" deleted successfully";
	}
	
	@GetMapping("/getMasterClasses")
	public List<MasterClass> findAllMasterClasses(){
		return masterClassUtil.retrieveMasterClassDetails();
	}
	
	@PostMapping("/addMasterClass")
	public String addMasterClass(@RequestBody MasterClass classes) {
		return "New Master Class added with ID : "+masterClassUtil.addNewMasterclass(classes);
	}
	
	@PostMapping("/removeMasterClass")
	public String removeMasterClass(@RequestBody MasterClass classes) {
		masterClassUtil.removeMasterclass(classes);
		return "Master Class with ID : "+classes.getClassId()+" deleted successfully";
	}
	
}
