import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Emicard } from '../emicard';
import { MyapiService } from '../myapi.service';
import { Product } from '../product';

@Component({
  selector: 'app-index',
  templateUrl: './index.component.html',
  styleUrls: ['./index.component.css']
})
export class IndexComponent implements OnInit {

  constructor(private userservice: MyapiService,private router:Router) {}
  result: any;
  cards: Array<Emicard>;
  prod:any;
  ngOnInit(): void {
    this.userservice.serachProductById(1).subscribe(
      (data)=>{
        this.prod=data as Product;
      },
      // (error)=>{
        // console.log("Error occured",error)
        // this.router.navigate(['/**'])

      // }
      )
    this.userservice.getAllEmiCard().subscribe((data) => {
      // console.log(data);
      this.result = data;
      // console.log(this.result);
      this.cards = data as Emicard[];
      console.log(this.cards);
    });
  }


}
