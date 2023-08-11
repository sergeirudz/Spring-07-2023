import { fileURLToPath } from "url";

// https://nuxt.com/docs/api/configuration/nuxt-config
export default defineNuxtConfig({
    modules: ["@nuxtjs/tailwindcss", "@pinia/nuxt", "@vueuse/nuxt", "@pinia-plugin-persistedstate/nuxt"],
    // plugins: ["~/plugins/pinia-plugin-persist.client"],
    pinia: {
        autoImports: [
            "defineStore", // import { defineStore } from 'pinia'
        ],
    },
    piniaPersistedstate: {
        cookieOptions: {
            sameSite: "strict",
        },
        storage: "localStorage",
    },
    devtools: { enabled: true },
    alias: {
        components: fileURLToPath(new URL("./components", import.meta.url)),
        layouts: fileURLToPath(new URL("./layouts", import.meta.url)),
        pages: fileURLToPath(new URL("./pages", import.meta.url)),
        types: fileURLToPath(new URL("./types", import.meta.url)),
        utils: fileURLToPath(new URL("./utils", import.meta.url)),
        store: fileURLToPath(new URL("./store", import.meta.url)),
        server: fileURLToPath(new URL("./server", import.meta.url)),
    },
    // srcDir: 'src',
    css: ["~/assets/css/tailwind.css"],
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
        apiSecret: "123",
        public: {
            BACKEND_URL: process.env.BACKEND_URL,
        },
    },
    ssr: true,
});
