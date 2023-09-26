<script setup>
import { ref } from 'vue';
import { ReadMessageService } from "@/services/readMessageService";
import { CreateMessageService } from "@/services/createMessageService";
import ResponseModal from './ResponseModal.vue';

const action = ref('read');
const messageId = ref('');
const messageContent = ref('');
const messageExpiry = ref('');
const serverResponse = ref('');
const showModal = ref(false);
const createService = new CreateMessageService();
const readService = new ReadMessageService();

const onActionChange = () => {
  console.log('Selected action:', action.value);
};

const onSubmit = () => {
  if (action.value === 'read') {
    const request = { id: messageId.value };

    readService.readMessage(request).then(response => {
      console.log('Received response:', response);
      serverResponse.value = response;
      showModal.value = true;
    });
  } else if (action.value === 'send') {
    const request = {
      content: messageContent.value,
      deleteAfterTime: messageExpiry.value
    };

    createService.createMessage(request).then(response => {
      console.log('Received response:', response);
      serverResponse.value = response;
      showModal.value = true;
    });
  }
};

const closeModal = () => {
  showModal.value = false;
};

const isCreateMessageResponse = (response) => {
  return response.hasOwnProperty('id');
};


const isReadMessageResponse = (response) => {
  return response.hasOwnProperty('content');
};
</script>


<template>
  <div class="container">
    <form @submit.prevent="onSubmit">
      <div class="form-group">
        <label for="action">Wybierz akcję:</label>
        <select class="form-control" id="action" v-model="action" @change="onActionChange">
          <option value="read">Przeczytaj wiadomość</option>
          <option value="send">Wyślij wiadomość</option>
        </select>
      </div>

      <div class="form-group" v-if="action === 'read'">
        <label for="messageId">Id wiadomości:</label>
        <input type="text" class="form-control" id="messageId" v-model="messageId">
      </div>

      <div v-if="action === 'send'">
        <div class="form-group">
          <label for="messageContent">Treść wiadomości:</label>
          <input type="text" class="form-control" id="messageContent" v-model="messageContent">
        </div>

        <div class="form-group">
          <label for="messageExpiry">Ile minut do usunięcia:</label>
          <input type="number" class="form-control" id="messageExpiry" v-model="messageExpiry">
        </div>
      </div>

      <button type="submit" class="btn btn-primary">Wykonaj</button>
    </form>

    <ResponseModal
        v-if="showModal.valueOf()"
        :serverResponse="serverResponse"
        :isCreateMessageResponse="isCreateMessageResponse"
        :isReadMessageResponse="isReadMessageResponse"
        @close-modal="closeModal"
    />
  </div>
</template>

<style scoped>

.container {
  display: flex;
  flex-direction: column;
  align-items: center;
  justify-content: center;
  height: 100vh;
  background-color: #e6f7ff;
}

form {
  background: #2196F3;
  padding: 2em;
  border-radius: 8px;
  box-shadow: 0 8px 16px 0 rgba(0,0,0,0.2);
  max-width: 500px;
  width: 100%;
}

.form-control {
  margin: 15px 0;
}

label {
  color: white;
}

.form-control,
select.form-control {
  width: 100%;
  padding: 12px;
  border: 1px solid #ccc;
  border-radius: 4px;
  box-shadow: 0 2px 4px 0 rgba(0,0,0,0.2);
  font-size: 16px;
  line-height: 1.2;
}

select.form-control {
  background: white;
  color: black;
  cursor: pointer;
  appearance: none;
  -webkit-appearance: none;
  -moz-appearance: none;
}

select.form-control option {
  background-color: #f2f2f2;
  color: black;
}

select.form-control::-ms-expand {
  display: none;
}

.form-control:focus,
select.form-control:focus {
  border-color: #5c8aff;
  box-shadow: 0 0 8px 0 rgba(0,0,0,0.2);
}

button {
  background-color: #4CAF50;
  color: white;
  padding: 14px 20px;
  margin: 8px 0;
  border: none;
  border-radius: 4px;
  cursor: pointer;
}

button:hover {
  background-color: #45a049;
}

.radio-group {
  display: flex;
  justify-content: space-between;
}

.radio-group label {
  color: white;
  margin-right: 10px;
}

.validation-error {
  color: red;
  margin-top: -10px;
  margin-bottom: 10px;
}

.modal-content {
  background: #2196F3;
  color: white;
  border-radius: 8px;
  box-shadow: 0 8px 16px 0 rgba(0,0,0,0.2);
}

.modal-title {
  color: white;
}

.modal-body {
  color: white;
}

.modal-footer button {
  background-color: #4CAF50;
  color: white;
  border: none;
  border-radius: 4px;
  cursor: pointer;
}

.modal-footer button:hover {
  background-color: #45a049;
}
</style>