package com.finance;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.finance.Model.CardDetails;
import com.finance.Model.Product;
import com.finance.Model.ProductHistory;
import com.finance.Model.User;
import com.finance.Repository.CardDetailsRepository;
import com.finance.Repository.ProductHistoryRepository;
import com.finance.Repository.UserRepository;
import com.finance.Service.CardDetailsService;
import com.finance.Service.ProductService;



@SpringBootTest
class FinanceApplicationTests {

	@Test
	void contextLoads() {
	}
	@Autowired
    ProductHistoryRepository finRep;
    @Autowired
    UserRepository usRep;
    @Autowired
    CardDetailsRepository cRep;
    @Autowired
	CardDetailsService cdService;
    @Autowired
	ProductService pService;

@Test
void testGetCardDetailsByRegIdP() {
	 long regid=26; //from database
	 assertEquals(false,cRep.findById(regid)==null);
	
}
@Test
void testGetCardDetailsByRegIdN() {
	 long regid=200;//not in database
	 System.out.println(cRep.findById(regid));
	assertEquals(false,cRep.findById(regid)==null);
	
	
}
@Test
void testGetProductsP() {
	
	 List<ProductHistory> l=finRep.findByRegid(26);//from database
	
	assertEquals(true,l.size() > 0);
	
}
@Test
void testGetProductsN() {
	 List<ProductHistory> l=finRep.findByRegid(103);//not in database
	assertEquals(true,l.isEmpty());
	
}
@Test
void testGetDetailsByRegIdP() {
	 long regid=26;//from database
		assertEquals(false,(usRep.findById(regid).get())==null);
}
@Test
void testGetDetailsByRegIdN() {
	 long regid=28;//not in database
		assertEquals(false,(usRep.findById(regid))==null);
}
@Test
void testAddProduct() {
	Product prod=new Product();
	prod.setProdid(567);//not from database
	prod.setProdname("Spear");
	String res=pService.addProducts(prod);
	assertEquals("Added",res);
	
}


@Test
void findUserP() {
	User u=usRep.findUserByUname("Prachi12");//from database
	assertEquals(false, u==null);
}
@Test
void findUserN() {
	User u=usRep.findUserByUname("Bhavesh7");//not in database
	assertEquals(true, u==null);
}
@Test
void testAddCard() {
	CardDetails card = new CardDetails();
	card.setRegid(27);//from database
	card.setCardtype("gold");//from database
	card.setInitialbal(40000);
	card.setAvailbal(39500);
	Date d =Date.valueOf(LocalDate.now().plusMonths( 24));
	card.setValidity(d);
	boolean res=cdService.addCard(card);
	System.out.println(res);
	
	        assertEquals(true, res);
	
}




}
