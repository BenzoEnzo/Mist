import axios from 'axios';

export class CreateMessageService {

    CREATE_MESSAGE_ENDPOINT = "http://127.0.0.1:8080/api/mist/create-message";
    createMessage(request) {
        console.log("Sending request to:", this.CREATE_MESSAGE_ENDPOINT);
        console.log("Request body:", request);

        return axios.post(this.CREATE_MESSAGE_ENDPOINT, request)
            .then(response => {
                console.log('Received response:', response.data);
                return response.data;
            })
            .catch(error => {
                console.error('Error during the request:', error);
                throw error;
            });
    }
}
