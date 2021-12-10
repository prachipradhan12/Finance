import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Carddetails } from '../carddetails';
import { MyapiService } from '../myapi.service';
import { User } from '../user';
import { UserDetails } from '../user-details';

@Component({
  selector: 'app-adminpage',
  templateUrl: './adminpage.component.html',
  styleUrls: ['./adminpage.component.css']
})
export class AdminpageComponent implements OnInit {

  user:UserDetails
  regid:any
  card:Carddetails
  //users:UserNew
  users:UserDetails
  id:number
  cardtype:any
  phone:any
  applied_on:any
  isverified:any
  constructor(private adminService:MyapiService,
    private aroute:ActivatedRoute, private router:Router) {
      this.card=new Carddetails();
      //this.users=new UserNew();
      this.users=new UserDetails();
     }
 
  ngOnInit(): void {
    this.adminService.getAllUsers().subscribe((data:any) =>{
      console.log(data);
      this.user=data;
      console.log(this.user.isverified);
      
 
  
      
    }
    );
  }
  OnDelete(regid:any){
    localStorage.setItem("regid",regid);
   
    this.regid=localStorage.getItem("regid");
    console.log(this.regid);
    
    // this.id=Number(this.regid)
    // this.users.regid=this.id;
    this.adminService.deleteTheUser(this.regid,this.users).subscribe(
      (data)=>{
        console.log("user values deleted")
        this.id=this.regid;
        console.log("ID",this.id)
      }
    )
    // let currentUrl = this. router. url;
    // this. router. routeReuseStrategy. shouldReuseRoute = () => false;
    // this. router. onSameUrlNavigation = 'reload';
    // this. router. navigate([currentUrl]);
    this.router.navigate(['/admindashboard'])
    // this.router.navigate(['/app-admin-page1'])
  }

    OnClick(regid:any)
    {
 
      localStorage.setItem("regid",regid);
     
      this.regid=localStorage.getItem("regid");
      console.log(this.regid);
      
      // this.id=Number(this.regid)
      // this.users.regid=this.id;
      this.adminService.updateTheUser(this.regid,this.users).subscribe(
        (data)=>{
          console.log("user values updated")
          this.id=this.regid;
          console.log("ID",this.id)
        }
      )
 
      this.router.navigate(['/admindashboard'])
 
    }
 
    createcard(regid:number,cardtype:string,phone:number,applied_on:Date){
      localStorage.setItem("regid",JSON.stringify(regid));
      this.regid=JSON.parse(localStorage.getItem("regid"));
      localStorage.setItem("cardtype",cardtype);
      this.cardtype=localStorage.getItem("cardtype");
      localStorage.setItem("phone",JSON.stringify(phone));
      this.phone=JSON.parse(localStorage.getItem("phone"));
      localStorage.setItem("applied_on",JSON.stringify(applied_on));
      this.applied_on=JSON.parse(localStorage.getItem("applied_on"));
 
      console.log(this.applied_on)
     console.log(this.regid)
     console.log(typeof this.regid);
      this.user.regid=this.regid;
      console.log(typeof this.user.regid);
    
        this.card.regid=this.regid;
       
      this.card.cardtype=this.cardtype;
      
      console.log(this.card.cardtype)
      console.log("VALIDITY",this.card.validity)
      this.card.cardno=(this.regid*100)+Math.random()*100;
     
      console.log(this.applied_on)
         if(this.card.cardtype=="gold")
      {
        this.card.initialbal=40000;
        this.card.availbal=39500;
        } 
        if(this.card.cardtype=="titanium"){
        this.card.initialbal=60000;
          this.card.availbal=59000;
           }
 
      
      this.adminService.addCard(this.card).subscribe(
        (data)=>{
      console.log("Return Value from REST"+data);
      
      
    })
    this.adminService.updateTheUser(this.regid,this.users).subscribe(
      (data)=>{
        console.log("user values updated")
        this.id=this.regid;
        console.log("ID",this.id)
      }
    )
    
    this.router.navigate(['/showallcards'])
 
    }


}
