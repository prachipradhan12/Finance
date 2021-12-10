import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { Router } from '@angular/router';
import { MyapiService } from '../myapi.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  userName: string;
  password: string;
  serviceoutput: number;
  usernameexists: boolean = true;
  passwordincorrect: boolean = true;
 
  constructor(private userservice: MyapiService, private router: Router) {}
 
  ngOnInit(): void {}
  onSubmit(loginForm: NgForm) {
    //console.log(loginForm.value.userName);
    this.usernameexists = true;
    this.passwordincorrect = true;
    this.userservice
      .validateUser(this.userName, this.password)
      .subscribe((data) => {
        //console.log(data);
        sessionStorage.setItem('userName', this.userName);
        console.log(sessionStorage.getItem('userName'));
        if (data == 1) {
          this.serviceoutput = 1;
          console.log('User does not exists');
          this.usernameexists = false;
          // console.log(this.serviceoutput);
        } else if (data == 2) {
          this.serviceoutput = 1;
          console.log('Logged in successfully');
          this.userservice.getIdByUname(this.userName).subscribe((data:any)=>{
            sessionStorage.setItem("regid",JSON.stringify(data));
      
           

            console.log("id",sessionStorage.getItem('regid'))
          });

          this.router.navigate(['/userdashboard']);

          // console.log(this.serviceoutput);
        } else {
          this.serviceoutput = 1;
          console.log('Incorrect password');
          // console.log(this.serviceoutput);
          this.passwordincorrect = false;
        }

      });
    // console.log(this.serviceoutput);
  }


}
