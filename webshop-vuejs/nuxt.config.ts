import { fileURLToPath } from 'url';

// https://nuxt.com/docs/api/configuration/nuxt-config
export default defineNuxtConfig({
  modules: ['@nuxtjs/tailwindcss', '@pinia/nuxt', '@vueuse/nuxt'],
  pinia: {
    autoImports: [
      // automatically imports `defineStore`
      'defineStore', // import { defineStore } from 'pinia'
      // ['defineStore', 'definePiniaStore'], // import { defineStore as definePiniaStore } from 'pinia'
    ],
  },
  devtools: { enabled: true },
  alias: {
    components: fileURLToPath(new URL('./components', import.meta.url)),
    layouts: fileURLToPath(new URL('./layouts', import.meta.url)),
    pages: fileURLToPath(new URL('./pages', import.meta.url)),
    types: fileURLToPath(new URL('./types', import.meta.url)),
    utils: fileURLToPath(new URL('./utils', import.meta.url)),
    store: fileURLToPath(new URL('./store', import.meta.url)),
  },
  // srcDir: 'src',
  css: ['~/assets/css/tailwind.css'],
  build: {
    // @ts-ignore TODO: fix TS error
    postcss: {
      postcssOptions: {
        plugins: {
          tailwindcss: {},
          autoprefixer: {},
        },
      },
    },
  },
  runtimeConfig: {
    BACKEND_URL: process.env.BACKEND_URL,
    apiSecret: '123',
    public: {
      BACKEND_URL: process.env.BACKEND_URL,
    },
  },
});
