<template>
  <NuxtLayout name="auth">
    <RegisterForm />
  </NuxtLayout>
</template>
<script setup lang="ts">
definePageMeta({
  middleware: ['guest-only'],
});

useHead({
  title: 'Register',
  meta: [
    {
      hid: 'description',
      name: 'description',
      content: 'Description Here',
    },
  ],
});
</script>
<style lang=""></style>
