import type { ViewStyle } from 'react-native';
import type { Theme } from './Theme';

export type LeanSdkProps = {
  userToken: string;
  options?: { environment: string };
  style: ViewStyle;
  theme?: Theme;
  onEvent?: (data: any) => void;
};
