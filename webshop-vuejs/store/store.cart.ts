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
        addOneToCart(product: Product) {
            const index = this.cartItems.findIndex((item) => item.id === product.id);
            if (index !== -1) {
                this.cartItems[index].nrInCart!++;
            } else {
                product.nrInCart = 1;
                this.cartItems.push(product);
            }
        },
        removeOneFromCart(product: Product) {
            const index = this.cartItems.findIndex((item) => item.id === product.id);

            if (this.cartItems[index].nrInCart! > 0) {
                this.cartItems[index].nrInCart!--;
            }

            if (this.cartItems[index].nrInCart === 0) {
                this.cartItems.splice(index, 1);
            }
        },
        deleteProductFromCart(product: Product) {
            const index = this.cartItems.findIndex((item) => item.id === product.id);
            this.cartItems.splice(index, 1);
        },
    },
    persist: {
        key: "cartStore",
    },
});
