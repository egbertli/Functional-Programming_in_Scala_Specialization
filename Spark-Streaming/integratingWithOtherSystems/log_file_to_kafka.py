from confluent_kafka import Producer

producer = Producer({'bootstrap.servers':'localhost:9092'})

def delivery_report(err, msg):
    """ Called once for each message produced to indicate delivery result.
        Triggered by poll() or flush(). """
    if err is not None:
        print('Message delivery failed: {}'.format(err))
    else:
        print('Message delivered to {} [{}]'.format(msg.topic(), msg.partition()))

total = 0
with open("access_log.txt", "r") as f:
    for line in f.readlines():
        # Trigger any available delivery report callbacks from previous produce() calls
        producer.poll(0)
      

        # Asynchronously produce a message, the delivery report callback
        # will be triggered from poll() above, or flush() below, when the message has
        # been successfully delivered or failed permanently.  
        producer.produce("testLogs", line.strip().encode('utf-8'), callback=delivery_report)
        total += 1
        print(line.strip(), " ", total)

# Wait for any outstanding messages to be delivered and delivery report
# callbacks to be triggered.
producer.flush()
