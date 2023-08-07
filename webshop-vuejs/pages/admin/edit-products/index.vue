<template lang="">
    <NuxtLayout name="default">
        <div>Edit Products page</div>
    </NuxtLayout>
</template>
<script setup lang="ts">
definePageMeta({
    middleware: ["admin-only"],
});
</script>
<style lang=""></style>
