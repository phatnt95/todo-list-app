import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { FormControl } from '@angular/forms';
import { Router } from '@angular/router';

@Component({
  selector: 'app-task-list-view',
  templateUrl: './task-list-view.component.html',
  styleUrls: ['./task-list-view.component.scss']
})
export class TaskListViewComponent implements OnInit {
  listTask: any = new Object;
  filter = new FormControl('');
  constructor(public httpClient: HttpClient, public router: Router) { }

  ngOnInit(): void {
    this.httpClient.get('http://localhost:8080/api/task/get').subscribe(data => {
      console.table(data)
      this.listTask = data
    })
  }

  add() {
    this.router.navigate(['task-form/null']);
  }

  edit() {

  }
}
