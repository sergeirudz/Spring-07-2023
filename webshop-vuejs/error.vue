<template>
  <NuxtLayout name="404">
    <div class="">
      <h1 class="">404 page here</h1>
      <button class="" @click="goBack">Back</button>
    </div>
  </NuxtLayout>
</template>

<script>
export default {
  methods: {
    goBack() {
      this.$router.push('/');
    },
  },
};
</script>

<style scoped></style>
