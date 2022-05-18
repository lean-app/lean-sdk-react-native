import * as React from 'react';

import {ScrollView, StyleSheet, View} from 'react-native';
import { LeanSdkView } from 'react-native-lean-sdk';

export default function App() {
  return (
    <ScrollView style={styles.container}>
      <View style={styles.box} />
      <View style={styles.box} />
      <View style={styles.box} />
      <LeanSdkView
        userToken=""
        style={styles.box}
        options={{ environment: 'STAGING' }}
      />
      <View style={styles.box} />
      <View style={styles.box} />
    </ScrollView>
  );
}

const styles = StyleSheet.create({
  container: {
    flex: 1,
  },
  box: {
    height: 240,
    backgroundColor: 'red',
  },
});
