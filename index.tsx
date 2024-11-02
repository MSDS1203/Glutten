import React from 'react'
import {StyleSheet, TextInput, Text, View} from 'react-native';

const Index = () => {
  const [number, onChangeNumber] = React.useState('');

  return (

      <View style={styles.view}>
        <Text style = {styles.text}>Glutten</Text>
        <TextInput
          style={styles.input}
          onChangeText={onChangeNumber}
          value={number}
          placeholder="Enter a Product"
          keyboardType="numeric"
        />

      </View>
  );
};

const styles = StyleSheet.create({
  input: {
    height: 40,
    margin: 12,
    borderWidth: 1,
    padding: 10,
  },

  text: {
    fontSize: 50,
    alignItems: 'center',
  },

  view: {
    flex: 1, 
    backgroundColor: '#c9f5e4',
    alignItems: 'center',
  }
});

export default Index;