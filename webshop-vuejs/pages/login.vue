<template>
  <NuxtLayout name="auth">
    <LoginForm />
  </NuxtLayout>
</template>
<script setup lang="ts">
import { useUserStore } from 'store/store.account';

// definePageMeta({
//     middleware: ["guest-only"],
// });

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
