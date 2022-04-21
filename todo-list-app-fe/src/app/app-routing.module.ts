import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { LoginFormComponent } from './login-form/login-form.component';
import { AuthGuardService as AuthGuard } from './service/auth-guard.service';
import { TaskFormComponent } from './task/task-form/task-form.component';
import { TaskListViewComponent } from './task/task-list-view/task-list-view.component';

const routes: Routes = [
  {
    path: '', redirectTo: 'login', pathMatch: 'full'
  },
  {
    path: 'login', component: LoginFormComponent
  },
  {
    path: 'task-view', component: TaskListViewComponent, canActivate: [AuthGuard]
  },
  {
    path: 'task-form/:id', component: TaskFormComponent, canActivate: [AuthGuard]
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
