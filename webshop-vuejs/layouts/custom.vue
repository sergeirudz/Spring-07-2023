<script setup lang="ts">
const { isDarkMode } = useDarkMode();
</script>

<template>
  <div
    :style="
      isDarkMode ? { backgroundColor: 'black' } : { backgroundColor: 'white' }
    "
  >
    <Nav />
    <slot />
  </div>
</template>
