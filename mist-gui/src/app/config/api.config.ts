import { environment } from '../environment/environment';

export const REST_API = `${environment.MIST_API}`;
export const READ_MESSAGE_ENDPOINT = `${REST_API}/read-message`;
export const CREATE_MESSAGE_ENDPOINT = `${REST_API}/create-message`;
