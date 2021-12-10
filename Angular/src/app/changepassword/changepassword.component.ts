import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { MyapiService } from '../myapi.service';
import { Namepass } from '../namepass';

@Component({
  selector: 'app-changepassword',
  templateUrl: './changepassword.component.html',
  styleUrls: ['./changepassword.component.css']
})
export class ChangepasswordComponent implements OnInit {

  newpass: string;
  confirmpass: string;
  passwordincorrect: boolean = true;
  namepass: Namepass;
 
  constructor(private userservice: MyapiService, private router: Router) {}
 
  ngOnInit(): void {}
  onSubmit(form: any) {
    if (this.newpass != this.confirmpass) {
      this.passwordincorrect = false;
    } else {
      this.namepass = new Namepass(
        sessionStorage.getItem('userName'),
        this.newpass
      );
      this.userservice.updatePassword(this.namepass).subscribe();
      console.log(this.namepass);
      this.router.navigate(['/loginLink']);
    }
  }

}
