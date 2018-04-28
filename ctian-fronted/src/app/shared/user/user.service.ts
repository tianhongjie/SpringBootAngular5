import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs/Observable';

@Injectable()
export class UserService {
  public CAR_API = '/api/users';

  constructor(private http: HttpClient) {
  }

  getAll(): Observable<any> {
    return this.http.get('/api/users');
  }

  get(id: string) {
    return this.http.get(this.CAR_API + '/' + id);
  }

  save(user: any, user_id: any): Observable<any> {
    let result: Observable<Object>;
    if (user_id) {
      result = this.http.put(this.CAR_API + "/" + user_id, user);
    } else {
      result = this.http.post(this.CAR_API, user);
    }
    return result;
  }

  remove(user_id: any) {
    return this.http.delete(this.CAR_API + "/" + user_id);
  }
}
