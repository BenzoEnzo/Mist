<template>
  <div id="app">
    <FormComponent />
  </div>
</template>

<script>
import FormComponent from '@/components/FormComponent.vue';
import ResponseModal from '@/components/ResponseModal.vue';
export default {
  name: 'App',
  components: {
    FormComponent,
    ResponseModal
  }
}
</script>
