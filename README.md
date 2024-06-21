# EasySpeak
EasySpeak is an app that uses smartphone cameras to translate Indonesian Sign Language (BISINDO) in real-time, bridging communication gaps between deaf and non-deaf individuals. It also serves as an educational tool for learning BISINDO, promoting inclusion and understanding in workplaces and daily interactions, fostering a more inclusive society.

### Team ID : C241-PS536

### Team Members :
1. (ML) M569D4KY3224– Suandi Simanjorang – Unika Santo Thomas University - [Active]
2. (ML) M004D4KY1389– Muhammad Abrar Maulana Haznul – Institute Technology of Sepuluh Nopember - [Active]
3. (ML) M200D4KY1926 – Dimas Fawwaz Prabowo Kusumaji – Diponegoro University - [Active]
4. (CC) C200D4KY0798 - Muhammad Dzaki Prasetyo – Diponegoro University - [Active]
5. (CC)  C200D4KY0098 – Alfarizi Hidayah – Diponegoro University - [Active]
6. (MD) A312D4KY4536 – Sandeas Saputra Rehar – Sebelas Maret University - [Active]
7. (MD) A312D4KY3834 – Muhammad Fauzan Hidayat – Sebelas Maret University - [Active]

### Theme :
Empowering Minds: A holistic approach to education and personal development

### Backgrounder :

#### Machine Learning
First, we prepared a dataset obtained from Kaggle. This dataset was obtained by combining several datasets on Kaggle, and we also combined it with our own dataset. After that, we preprocessed the dataset. The first preprocessing step is to resize the dataset to 128x128. After that, the second preprocessing stage is to convert all datasets to grayscale. After that, the dataset was divided into 3, namely training, validation, and testing, with a ratio of 0.8, 0.1, and 0.1.

After completing preprocessing, we continued training the model. We use the Convolutional Neural Network (CNN) for our model. After a lot of trial and error, we settled on a model with an accuracy of 98 and a validation accuracy of 98. After that, we tested the model to classify the testing data. Our model succeeded in achieving an accuracy of 99 on testing data. After that, we deploy the model into TFLite.

#### Cloud Computing
First, we create a compute engine for the VM instance. The compute engine is used to deploy the login API, machine learning model, and landing page. Our database uses MySQL to store user data, and data for dictionary features. We also use Google Cloud Storage to store the data needed on the landing page such as images.

#### Mobile Development
First, we designed the UI/UX together using Figma. After some evaluation, we tried to apply the display from Figma to XML in Android Studio. After several experiments, we succeeded in creating a defined display starting from the homepage, login page, register page, sign language converting display and then quiz.

Deployment of TensorFlow lite and creation of both a user and an admin app. The application has a real-time connection using Firebase and a mechanism to a data buffer in case an internet connection is unavailable.
