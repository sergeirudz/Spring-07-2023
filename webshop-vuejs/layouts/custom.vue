<script setup lang="ts">
const { isDarkMode } = useDarkMode();
</script>

<template>
  <div
    :style="
      isDarkMode ? { backgroundColor: 'black' } : { backgroundColor: 'white' }
    "
    class="min-h-screen flex flex-col justify-between"
  >
    <Nav />
    <main
      class="container mx-auto flex flex-col bg-gray-500 flex-1 align-center"
    >
      <slot />
    </main>
    <Footer />
  </div>
</template>
