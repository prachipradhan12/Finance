import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { Router } from '@angular/router';

import { Carddetails } from '../carddetails';
import { MyapiService } from '../myapi.service';
import { Product } from '../product';
import { Producthistory } from '../producthistory';

@Component({
  selector: 'app-productdetails',
  templateUrl: './productdetails.component.html',
  styleUrls: ['./productdetails.component.css']
})
export class ProductdetailsComponent implements OnInit {

  prodid:any;
  prod:Product;
  productimage:any;
  emi3m:any;
  emi6m:any;
  emi9m:any;
  emi1y:any;
  card:Carddetails;
  prodhist:Producthistory;
  status:boolean;
  productprice:any;
  processingfees:any;
  usname:any;
  price:any;
  constructor(private pservice:MyapiService,private router:Router) { }
regid:any;
  ngOnInit(): void {
    this.regid=JSON.parse(sessionStorage.getItem("regid"));
    this.usname=sessionStorage.getItem('userName');
    this.prodid=localStorage.getItem("prodid");
    this.price=localStorage.getItem("regid");
    this.pservice.serachProductById(this.prodid).subscribe(
      (data)=>{
        this.prod=data as Product;
        this.prodhist=data as Producthistory;
        this.productimage=this.prod.prodimage;
        this.prodhist.prodid=this.prod.prodid;
        this.prodhist.prodname=this.prod.prodname;
        this.prodhist.regid=this.regid;
        this.productprice=this.prod.price;
        this.prodhist.price=this.prod.price;
        this.processingfees=this.productprice*0.01;
        // this.prodhist.price=this.price;

        
      }
      )
  }
  chosenMod: string = "";
  emivalue:number=0;

modo(){
  
  switch(this.chosenMod) {  
     case "mod1": { 
        this.emivalue=this.prod.emi_3m;
        this.prodhist.amountpaid=this.emivalue+this.processingfees;
        this.prodhist.ammount_bal=this.prod.price-this.prodhist.amountpaid;
        break;
     }
     case "mod2": { 
        this.emivalue=this.prod.emi_6m;
        this.prodhist.amountpaid=this.emivalue+this.processingfees;
        this.prodhist.ammount_bal=this.prod.price-this.prodhist.amountpaid;
        break;
     }
     case "mod3": { 
        this.emivalue=this.prod.emi_9m;
        this.prodhist.amountpaid=this.emivalue+this.processingfees;
        this.prodhist.ammount_bal=this.prod.price-this.prodhist.amountpaid;
        break;
     }
     case "mod4":{
       this.emivalue=this.prod.emi_1y;
       this.prodhist.amountpaid=this.emivalue+this.processingfees;
       this.prodhist.ammount_bal=this.prod.price-this.prodhist.amountpaid;
       break;
     }
  }
}
SelectedEMI: any;
emiselected($event) {
  this.SelectedEMI = $event.target.options[$event.target.options.selectedIndex].text;
  this.prodhist.emi=this.SelectedEMI;
 

}
saveData()
{

   
   this.pservice.updateProduct(this.prodhist.regid,this.prodhist.price,this.card).subscribe(
      (data)=>{

        this.status=data as boolean;
        if(this.status==false){
          alert("Insufficient Balance");
          this.router.navigate(['/userdashboard'])
      

        }
        else{
          this.pservice.addNewProduct(this.prodhist).subscribe(
            (data)=>{
              console.log("Return Value from REST"+data);
              
              
              
            },
            (error)=>{
              console.log("Error occured",error)
              
            }
          )
          alert("Continue Shopping")
          this.router.navigate(['/products'])
 
        }
        
      },
      (error)=>{
        console.log("Error occured",error)
        this.router.navigate(['/**'])

      }
    )
  
}




}
