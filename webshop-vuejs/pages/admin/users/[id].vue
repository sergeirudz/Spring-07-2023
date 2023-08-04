<template lang="">
  <NuxtLayout name="default">
    <div>Edit one user page - {{ name }}</div>
  </NuxtLayout>
</template>
<script>
// import {} from "#app";
const route = useRoute();
const name = route.params.name;

export default {};
</script>
<style lang=""></style>
