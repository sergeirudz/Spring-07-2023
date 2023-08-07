<template lang="">
    <NuxtLayout name="custom">
        <h1 class="text-xl">Cart Page</h1>
    </NuxtLayout>
</template>
<script setup lang="ts">
definePageMeta({
    middleware: ["user-only"],
});

useHead({
    title: "Cart Page",
    meta: [
        {
            hid: "description",
            name: "description",
            content: "Description Here",
        },
    ],
});
</script>
<style lang=""></style>
