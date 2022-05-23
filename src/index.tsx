import {
  requireNativeComponent,
  UIManager,
  Platform,
  NativeSyntheticEvent,
} from 'react-native';
import type { LeanSdkProps } from './types/LeanProps';
import React from 'react';

const LINKING_ERROR =
  `The package 'react-native-lean-sdk' doesn't seem to be linked. Make sure: \n\n` +
  Platform.select({ ios: "- You have run 'pod install'\n", default: '' }) +
  '- You rebuilt the app after installing the package\n' +
  '- You are not using Expo managed workflow\n';

const ComponentName = 'LeanSdkView';

const NativeView =
  UIManager.getViewManagerConfig(ComponentName) != null
    ? requireNativeComponent<
        LeanSdkProps & {
          onChange: (event: NativeSyntheticEvent<{ data: any }>) => void;
        }
      >(ComponentName)
    : () => {
        throw new Error(LINKING_ERROR);
      };

export const LeanSdkView = (props: LeanSdkProps) => {
  return (
    <NativeView
      {...props}
      onChange={(event) => {
        props.onEvent ? props.onEvent(event.nativeEvent.data) : null;
      }}
      onEvent={(event) => {
        props.onEvent ? props.onEvent(event.nativeEvent.data) : null; // ios only
      }}
    />
  );
};
