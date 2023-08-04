import { fileURLToPath } from 'url';

// https://nuxt.com/docs/api/configuration/nuxt-config
export default defineNuxtConfig({
  devtools: { enabled: true },
  alias: {
    components: fileURLToPath(new URL('./components', import.meta.url)),
    layouts: fileURLToPath(new URL('./layouts', import.meta.url)),
    pages: fileURLToPath(new URL('./pages', import.meta.url)),
  },
  // srcDir: 'src',
});
