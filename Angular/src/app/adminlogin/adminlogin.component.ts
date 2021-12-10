import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Adminlogin } from '../adminlogin';
import { MyapiService } from '../myapi.service';

@Component({
  selector: 'app-adminlogin',
  templateUrl: './adminlogin.component.html',
  styleUrls: ['./adminlogin.component.css']
})
export class AdminloginComponent implements OnInit {

  var:Adminlogin;
  n:any;
  name:string;
  password:string;
  message:string
 
 
  constructor( private adService:MyapiService,private router:Router ) {
    this.var=new Adminlogin;
    
   }
 
  ngOnInit(): void {
  }
 
    checkAdmin(){
      this.adService.getAdmin(this.name,this.password).subscribe(
        (data)=>{
          this.n=data;
          console.log(data);
          console.log(this.n);
          if (this.n==1) {
            this.message="User-name is invalid/does not exist"
          } if(this.n==3) {
            this.message="Wrong Password"
          }if(this.n==2){
            this.message="Succefully logged-In";
            this.router.navigate(['/admindashboard']);
          }
        }
      )
 
    }


}
