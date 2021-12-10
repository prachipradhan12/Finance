import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Producthistory } from './producthistory';

import { Carddetails } from './carddetails';
import { Product } from './product';
import { User } from './user';
import { Namepass } from './namepass';
import { UserDetails } from './user-details';

@Injectable({
  providedIn: 'root'
})
export class MyapiService {

  constructor(private httpClient:HttpClient) { }
  baseUrl:string="http://localhost:9797//api";
  CardbaseUrl="http://localhost:9797/cardapi/updatebal/"

  //RETRIEVING ALL PRODUCTS
  getAllProducts()
  {
    return this.httpClient.get(this.baseUrl+"/products");
  }

  serachProductById(productid:number)
  {
    return this.httpClient.get(this.baseUrl+"/products/"+productid);
  }
  serachProductByName(pname:string)
  {
    return this.httpClient.get(this.baseUrl+"/products/productname/"+pname);
  }
  addNewProduct(product:Producthistory)
  {
    return this.httpClient.post("http://localhost:9797/producthistory/api/ph",product);
  }
  updateProduct(regid:number,price:number,card:Carddetails)
  {

    return this.httpClient.put(this.CardbaseUrl+regid+'/'+price,card);
  }
  updateProduct1(product:Product)
  {
    return this.httpClient.put(this.baseUrl+"/products",product);
  }
  baseUrlCard: string = 'http://localhost:9797/emicardRest/api';
  getAllEmiCard() {
    return this.httpClient.get(this.baseUrlCard + '/cards');
  }
  baseUrlUser: string = 'http://localhost:9797/userRest/api';
  validateUser(uname: string, upass: string) {
    return this.httpClient.get(
      this.baseUrlUser + '/uservalidate/' + uname + '/' + upass
    );
  }
  addNewUser(user: User) {
    return this.httpClient.post(this.baseUrlUser + '/user', user);
  }
    checkUserExists(uname: string) {
    return this.httpClient.get(this.baseUrlUser + '/userexists/' + uname);
  }
  updatePassword(namepass: Namepass) {
    console.log(namepass);
    return this.httpClient.put(this.baseUrlUser + '/changepass', namepass);
  }
  getIdByUname(uname:string){
    return this.httpClient.get(this.baseUrlUser+'/getId/'+uname);
  }
  baseUrlR:string="http://localhost:9797//financeRest/api";
  getHistoryById(regid:number){
    return this.httpClient.get(this.baseUrlR+"/financeHistory/"+regid);
  
  }
  
  getUserDetailsById(regid:number){
    return this.httpClient.get(this.baseUrlR+"/details/"+regid);
  }
  
  getCardDetailsById(regid:number){
    return this.httpClient.get(this.baseUrlR+"/carddetails/"+regid);
  }
  baseUrlS:string="http://localhost:9797/adminRest/api/validate/";
  getAdmin(name:string,pass:string){
    return this.httpClient.get(this.baseUrlS+ name+"/"+pass);
    
  }
  baseUrlSB:string="http://localhost:9797//UserDetailsRest/api"
  
  
  getAllUsers()
  {
    return this.httpClient.get(this.baseUrlSB+"/userDetails")
  }
  // getAllCards(){
  //   return this.httpClient.get(this.baseUrlSB+"/cardDetails")
  // }
  
  updateUser(regid:number)
  {
    return this.httpClient.put(this.baseUrlSB+"/userDetails/"+regid,regid);
  }
  updateTheUser(regid:any,users:UserDetails)
  {
 
    return this.httpClient.put("http://localhost:9797//UserDetailsRest/api/userDetails/"+regid,users);
  }
  deleteTheUser(regid:any,users:UserDetails)
  {
 
    return this.httpClient.delete("http://localhost:9797//UserDetailsRest/api/userDetails/"+regid);
  }
  searchUserById(regid:number)
  {
    return this.httpClient.get(this.baseUrlSB+"/userDetails/"+regid);
  }
  addCard(card:Carddetails)
  {
    return this.httpClient.post("http://localhost:9797//UserDetailsRest/api/cardDetails",card);
  }  
  getAllCards(){
    return this.httpClient.get(this.baseUrlSB+"/cardDetails")
  }
  baseUrlRP:string="http://localhost:9797/api";
 
 
 addProducts(finProduct:Product){
   return this.httpClient.post(this.baseUrl+"/products",finProduct);

 }


 







}
