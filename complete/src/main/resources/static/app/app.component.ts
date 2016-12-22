import { Component } from '@angular/core';

@Component({
    selector: 'my-app',
    templateUrl: '/app/my-app.html'
})
export class AppComponent {

    counter: string = 'not known';
    ws: $Websocket;
    cws: $Websocket;
    sock : SockJS;
    dd:SockJS;
    stompClient:Stomp;
    from:string;
    to:string;
    text:string;

    constructor() {

    }

    public connect() :void {
        var socket = new SockJS('/chat');
        this.stompClient = Stomp.over(socket);
        var x = this.stompClient;
        this.stompClient.connect({}, function (frame) {
            console.log('Connected: ' + frame);
            x.subscribe('/topic/messages', function (message) {
                var msg = JSON.parse(message.body);
                console.log('got message ' + msg.from + ' --> ' + msg.to + ' : ' + msg.text );
            });
        });
    }

    public disconnect() :void {
        if (this.stompClient != null) {
            this.stompClient.disconnect();
            this.stompClient = null;
        }
        console.log("Disconnected");
    }

    public send(from, to, text) :void {
        this.stompClient.send("/chat", {}, JSON.stringify(
            {'from': from, 'to':to, text:text }
        ));
    }

    public isConnected() : boolean {
        return this.stompClient != null;
    }

}
