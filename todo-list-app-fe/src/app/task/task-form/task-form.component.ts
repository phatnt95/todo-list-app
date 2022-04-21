import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormControl, FormGroup, Validators } from '@angular/forms';
import { ActivatedRoute } from '@angular/router';

@Component({
    selector: 'app-task-form',
    templateUrl: './task-form.component.html',
    styleUrls: ['./task-form.component.scss']
})
export class TaskFormComponent implements OnInit {

    defaultValue: any = {

        'value': -1,
        'display': 'Select One'

    }
    title: string = 'Thêm mới Task'
    task: any = {};
    parent_tasks: any[] = [
        this.defaultValue
    ];
    types: any[] = ['TASK', 'BUG'];
    status: any[] = [
        'TO_DO',
        'IN_PROGRESS',
        'REOPEN',
        'DONE'
    ];
    taskForm!: FormGroup;

    constructor(
        private formBuilder: FormBuilder,
        private activatedRoute: ActivatedRoute,
        private httpClient: HttpClient) {
        this.httpClient.get<any[]>('http://localhost:8080/api/task/get').subscribe(data => {
            if (data.length > 0) {
                data.forEach(ele => {
                    this.parent_tasks.push({
                        'value': ele['id'],
                        'display': ele['task_name']
                    });
                });
                console.table(this.parent_tasks)
            }
        });

    }

    ngOnInit(): void {
        this.taskForm = this.formBuilder.group({
            task_name: ['', Validators.required],
            parent_task: ['', Validators.required],
            type: ['', Validators.required],
            status: ['', Validators.required]
        })

        const id = this.activatedRoute.snapshot.paramMap.get('id');
        if (id) {
            this.title = 'Chỉnh sửa Task';
            this.httpClient.get('http://localhost:8080/api/task/get/' + id).subscribe(data => {
                this.task = data;
                console.log(data);
            });
        }
    }

    save() {
        this.httpClient.post('http://localhost:8080/api/task/save', this.task).subscribe(res => {

        });
    }

    clear() {

    }

}
