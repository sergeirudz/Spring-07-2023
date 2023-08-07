<template>
  <NuxtLayout name="auth">
    <LoginForm />
  </NuxtLayout>
</template>
<script setup lang="ts">
useHead({
  title: 'Login page',
  meta: [
    {
      hid: 'description',
      name: 'description',
      content: 'Description Here',
    },
  ],
});
</script>
<style></style>
