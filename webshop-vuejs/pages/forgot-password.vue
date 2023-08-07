<template lang="">
  <NuxtLayout name="auth">
    <ForgotPasswordForm />
  </NuxtLayout>
</template>
<script setup lang="ts">
useHead({
  title: 'Forgot password',
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
