import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { Router } from '@angular/router';
import { MyapiService } from '../myapi.service';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent implements OnInit {

  name: string;
  phone: number;
  dob: Date;
  email: string;
  uname: string;
  upass: string = '';
  ucpass: string = '';
  address: string;
  // confirmPassword: string;
  cardtype: string;
  bankname: string;
  acc_no: number;
  ifsc_code: string;
 
  passwordmatch: boolean = true;
  unameexists: boolean = true;
  serviceoutput: boolean;
  constructor(private userservice: MyapiService, private router: Router) {}
 
  ngOnInit(): void {}
  onSubmit(registerForm: NgForm) {
    console.log(registerForm.value);
    if (this.ucpass != this.upass) {
      this.passwordmatch = false;
      return;
    }
    this.userservice.checkUserExists(this.uname).subscribe((data) => {
      if (data) {
        this.unameexists = false;
        this.serviceoutput = true;
        this.passwordmatch = true;
      } else {
        this.serviceoutput = false;
        this.router.navigate(['/loginLink']);
        this.userservice.addNewUser(registerForm.value).subscribe();
      }
      console.log(this.serviceoutput);
    });
    // console.log(this.resultvalue);
 
    //this.userservice.addNewUser(registerForm.value).subscribe();
  }

}
