import { Component, OnInit } from '@angular/core';
import {ToastService} from "../../services/toast.service";

@Component({
  selector: 'app-toasts',
  templateUrl: './toasts.component.html',
  styleUrls: ['./toasts.component.css'],
  host: {'class': 'toast-container position-fixed top-0 end-0 p-3', 'style': 'z-index: 1200'}
})
export class ToastsComponent implements OnInit {

  constructor(public toastService:ToastService) { }

  ngOnInit(): void {
  }

}
