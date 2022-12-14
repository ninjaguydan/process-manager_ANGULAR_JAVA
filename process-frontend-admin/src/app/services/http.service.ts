import {Injectable} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {IStage} from "../interfaces/IStage";
import {IProcess} from "../interfaces/IProcess";
import {Observable} from "rxjs";

@Injectable({
	providedIn: 'root'
})
export class HttpService {

	constructor(private httpClient: HttpClient) {
	}

	//-------------------- PROCESSES --------------------
	GET_PROCESSES():Observable<IProcess[]>{
		return this.httpClient.get<IProcess[]>('http://localhost:8080/processes')
	}
	CREATE_PROCESS(process:IProcess) {
		return this.httpClient.post('http://localhost:8080/processes',{...process})
	}
	DELETE_PROCESS(processId:number){
		return this.httpClient.delete(`http://localhost:8080/processes/${processId}`)
	}
	EDIT_PROCESS(process:IProcess, toDelete:IStage[]) {
		return this.httpClient.put('http://localhost:8080/processes', {...process, cleanUp:toDelete})
	}
}
