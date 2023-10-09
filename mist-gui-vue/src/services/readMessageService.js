import axios from 'axios'
export class ReadMessageService {
READ_MESSAGE_ENDPOINT = "http://127.0.0.1:8080/api/mist/read-message";

    readMessage(request) {
        if (!request.id || Object.keys(request).length === 0) {
            console.error('Request is empty');
            return Promise.resolve();
        }

        return axios.post(this.READ_MESSAGE_ENDPOINT, request)
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

