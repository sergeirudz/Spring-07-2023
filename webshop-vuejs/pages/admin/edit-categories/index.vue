<template lang="">
    <NuxtLayout name="default">
        <div>Edit categories page</div>
    </NuxtLayout>
</template>
<script setup lang="ts">
definePageMeta({
    middleware: ["admin-only"],
});
</script>
<style lang=""></style>
