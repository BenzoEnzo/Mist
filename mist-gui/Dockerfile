# Stage 1: Budowa aplikacji Angularowej
FROM node:17 as build
ARG MIST_API
WORKDIR /app
ENV MIST_API=${MIST_API}
COPY package.json package-lock.json ./
RUN npm install
COPY . .
RUN npm run start

# Stage 2: Tworzenie obrazu docelowego
FROM nginx
COPY nginx/default.conf /etc/nginx/conf.d/default.conf
COPY dist/mist-gui /usr/share/nginx/html
EXPOSE 80
CMD ["nginx", "-g", "daemon off;"]
