#/bin/sh
# This script lives at https://raw.github.com/CheffPJ/jboss-as/linux_init/linux/src/main/resources/ks/base-ks.cfg, but ks doesn't like https

export TMP_DIR=/tmp/push-as7-linux

rm -rf $TMP_DIR 2>/dev/null
mkdir -p $TMP_DIR
cd $TMP_DIR

wget https://raw.github.com/CheffPJ/jboss-as/linux_init/linux/src/main/resources/{ks/lightining-lovelock-ks.cfg,etc/rsyslog.d/jboss-as.conf,lib/systemd/system/jboss-as.service,etc/jboss-as.d/domain.xml,etc/jboss-as.d/host.xml}

ssh pmcdonou@people.redhat.com 'rm /home/remote/pmcdonou/public_html/src/jboss-as7-linux/*'
scp * people.redhat.com:/home/remote/pmcdonou/public_html/src/jboss-as7-linux/
