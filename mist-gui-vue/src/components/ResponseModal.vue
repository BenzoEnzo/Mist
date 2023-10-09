<script setup>


const props = defineProps({
  serverResponse: Object,
  isCreateMessageResponse: Function,
  isReadMessageResponse: Function,
});

const emits = defineEmits(['close-modal']);

const onClose = () => {
  emits('close-modal');
};

const copyToClipboard = (id) => {
  const textToCopy = id === 'code' ? props.serverResponse.id : props.serverResponse.content;
  if (navigator.clipboard) {
    navigator.clipboard.writeText(textToCopy)
        .then(() => {
          console.log('Skopiowano do schowka: ', textToCopy);
        })
        .catch(err => {
          console.error('Błąd kopiowania do schowka: ', err);
        });
  } else {
    console.warn('Twoja przeglądarka nie obsługuje API Clipboard');
  }
};

</script>



<template>
  <div class="response-modal">
    <div class="modal-content">
      <button class="close-button" @click="onClose">
        <span class="close-icon" aria-hidden="true">&times;</span>
      </button>
      <div v-if="serverResponse">
        <div v-if="isCreateMessageResponse(serverResponse)">
          <p>
            Kod wiadomości:
            <span class="copy-text">{{ serverResponse.id }}
              <i class="fas fa-copy copy-icon" @click="copyToClipboard('code')"></i>
            </span>
          </p>
        </div>
        <div v-if="isReadMessageResponse(serverResponse)">
          <p>
            Treść wiadomości:
            <span class="copy-text">{{ serverResponse.content }}
              <i class="fas fa-copy copy-icon" @click="copyToClipboard('content')"></i>
            </span>
          </p>
        </div>

      </div>
    </div>
  </div>
</template>



<style scoped>
.response-modal {
  background-color: rgba(0, 0, 0, 0.5);
  position: fixed;
  top: 0;
  left: 0;
  right: 0;
  bottom: 0;
  display: flex;
  align-items: center;
  justify-content: center;
}

.modal-content {
  background-color: #fff;
  padding: 20px;
  border-radius: 5px;
  box-shadow: 0 0 10px rgba(0, 0, 0, 0.2);
  width: 500px;
  min-height: 100px;
  position: relative;
  overflow-y: auto;
  overflow-x: auto;
}

.close-button {
  position: absolute;
  top: 10px;
  right: 10px;
  font-size: 20px;
  color: #333;
  cursor: pointer;
  background: none;
  border: none;
}

.close-button:hover {
  color: red;
}

.close-icon {
  font-size: 20px;
}

.copy-icon {
  font-size: 20px;
  color: #333;
  cursor: pointer;
  margin-left: 5px;
  text-shadow: 1px 1px 2px rgba(0, 0, 0, 0.5);
  padding: 5px;
}

.copy-icon:hover {
  color: red;
}

.copy-text {
  font-weight: bold;
  padding: 5px;
  transition: box-shadow 0.3s ease;
}

.copy-text:hover {
  box-shadow: 0 0 2px rgba(255, 255, 255, 0.5),
  0 0 2px rgba(255, 255, 255, 0.5),
  0 0 2px rgba(255, 255, 255, 0.5);
}
</style>