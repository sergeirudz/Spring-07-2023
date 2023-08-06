const useDarkMode = () => {
  const isDarkMode = useState<boolean>('darkMode', () => false);

  const setDarkMode = (value: boolean) => {
    isDarkMode.value = value;
  };

  return {
    isDarkMode,
    setDarkMode,
  };
};

export default useDarkMode;
