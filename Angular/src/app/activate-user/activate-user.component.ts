import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { MyapiService } from '../myapi.service';
import { UserDetails } from '../user-details';

@Component({
  selector: 'app-activate-user',
  templateUrl: './activate-user.component.html',
  styleUrls: ['./activate-user.component.css']
})
export class ActivateUserComponent implements OnInit {

  regid:any;
  user:UserDetails;
  radioVal:any;
  user1:any;
  cards:any
  //card:any
 
  constructor(private router:Router, private adservice:MyapiService, private aroute:ActivatedRoute,) { 
    //this.user=new Userdetails();
    
  }
  
 
  ngOnInit(): void {
 
 
    this.adservice.getAllCards().subscribe((data:any) =>{
      console.log(data);
      this.cards=data;
      
 
  
      
    }
    );
  }


}
