import { Component, OnInit } from '@angular/core';
import { MyapiService } from '../myapi.service';
import { Product } from '../product';

@Component({
  selector: 'app-addproduct',
  templateUrl: './addproduct.component.html',
  styleUrls: ['./addproduct.component.css']
})
export class AddproductComponent implements OnInit {

  finProd:Product;
  prodimage:any;
 
  constructor(private finServ:MyapiService) {
    this.finProd=new Product();
    
   
   }
  
  ngOnInit(): void {
    console.log(this.finProd);
  }
  saveData()
  {
    this.finProd.prodimage=this.finProd.prodimage.split('\\').pop();
     console.log(this.finProd);
     console.log("Image",this.finProd.prodimage);
  
      this.finServ.addProducts(this.finProd).subscribe(
        (data)=>{
          console.log("Return Value from REST"+data);
        }
      )
   
  }
  calculateEmi(price:any){
    this.finProd.emi_3m=Math.ceil(price/3);
    this.finProd.emi_6m=Math.ceil(price/6);
    this.finProd.emi_9m=Math.ceil(price/9);
    this.finProd.emi_1y=Math.ceil(price/12);


  }
 

}
