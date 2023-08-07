<template lang="">
    <NuxtLayout name="default">
        <div>Edit one user page - {{ name }}</div>
    </NuxtLayout>
</template>

<script setup lang="ts">
const route = useRoute();
const name = route.params.name;
definePageMeta({
    middleware: ["admin-only"],
});
</script>
<style lang=""></style>
