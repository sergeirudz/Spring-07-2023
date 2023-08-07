import { defineStore } from 'pinia';

import { User } from 'types/models/User';

const initialState: Omit<User, 'id'> = {
  email: '',
  isAdmin: false,
  isLoggedIn: false,
  accessToken: '',
  refreshToken: '',
};

export const useUserStore = defineStore('userStore', {
  state: (): Omit<User, 'id'> => {
    return initialState;
  },
  actions: {
    updateLoginState(this: User, payload: boolean) {
      this.isLoggedIn = payload;
    },
    updateAccessToken(this: User, payload: string) {
      this.accessToken = payload;
    },
    updateRefreshToken(this: User, payload: string) {
      this.refreshToken = payload;
    },
    logout(this: User) {
      this.email = '';
      this.isAdmin = false;
      this.isLoggedIn = false;
      this.accessToken = '';
      this.refreshToken = '';
    },
  },
});
