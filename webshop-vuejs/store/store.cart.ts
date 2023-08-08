import { Product } from "types/models/Product";
import { createPinia } from "pinia";
import piniaPluginPersistedstate, { createPersistedState } from "pinia-plugin-persistedstate";

const pinia = createPinia();
pinia.use(piniaPluginPersistedstate);

export const useCartStore = defineStore("cartStore", {
    state: () => ({
        cartItems: [] as Product[],
    }),
    actions: {
        addToCart(product: Product) {
            this.cartItems.push(product);
        },
        removeFromCart(product: Product) {
            const index = this.cartItems.findIndex((item) => item.id === product.id);
            if (index !== -1) {
                this.cartItems.splice(index, 1);
            }
        },
    },
    persist: {
        key: "cartStore",
        // beforeRestore: (ctx) => {
        //     console.log(`about to restore '${ctx.store.$id}'`);
        // },
        // afterRestore: (ctx) => {
        //     console.log(`just restored '${ctx.store.$id}'`);
        // },
    },
});

// https://prazdevs.github.io/pinia-plugin-persistedstate/guide/config.html
