<template lang="">
    <NuxtLayout name="default">
        <div>Pay page</div>
    </NuxtLayout>
</template>
<script setup lang="ts">
definePageMeta({
    middleware: ["user-only"],
});

useHead({
    title: "Payment page",
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
